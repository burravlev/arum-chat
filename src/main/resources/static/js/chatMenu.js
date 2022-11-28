const chats = document.getElementById('chats');

function chatPreview(chat) {
    let item = document.createElement('li');
    item.classList.add('chat');

    let avatar = document.createElement('div');
    let img = document.createElement('img');
    img.src = "https://i.pinimg.com/280x280_RS/2e/45/66/2e4566fd829bcf9eb11ccdb5f252b02f.jpg";
    avatar.classList.add('avatar');
    avatar.appendChild(img);

    let mainInfo = document.createElement('div');
    mainInfo.classList.add('main-info');

    let chatInfo = document.createElement('div');
    chatInfo.classList.add('chat-info');

    let user = document.createElement('div');
    user.classList.add('user');
    user.appendChild(document.createTextNode(chat.secondUser));

    let lastMag = document.createElement('div');
    lastMag.classList.add('last-msg');
    lastMag.appendChild(document.createTextNode(chat.lastMessage));

    chatInfo.appendChild(user);
    chatInfo.appendChild(lastMag);

    item.appendChild(avatar);
    item.appendChild(chatInfo);
    chats.appendChild(item);
}

let chatExample = {
    secondUser: 'User',
    lastMessage: 'Hello'
}

const newChatBtn = document.getElementById('new');

newChatBtn.addEventListener('click', chatPreview);