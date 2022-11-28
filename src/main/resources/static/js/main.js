const sender = document.getElementById('sender');
const receiver = document.getElementById('receiver');
const content = document.getElementById('content');

const chats = document.getElementById('chats');
const send = document.getElementById('send');
const connectBtn = document.getElementById('connect');

let stompClient = null;

function connection(event) {
    if (sender) {
        let socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}

function onConnected() {
    stompClient.subscribe('/user/' + sender.value.trim() + '/private', onMessageReceived);
}

//Создание сообщения
function onMessageReceived(payload) {
    let message = JSON.parse(payload.body);
    let messageElement = document.createElement('li');
    messageElement.appendChild(document.createTextNode(message.content));
    chats.appendChild(messageElement);
}

function onError(error) {
    console.log(error);
}

function sendMessage(event) {
    let messageContent = content.value.trim();
    if (messageContent && stompClient) {
        let chatMessage = {
            sender: sender,
            receiver: receiver,
            content: messageContent
        }
        stompClient.send('/user/' + receiver.value.trim() + '/private', {}, JSON.stringify(chatMessage));
        content.value = '';
    }
    event.preventDefault();
}

connectBtn.addEventListener('click', connection);
send.addEventListener('click', sendMessage);


