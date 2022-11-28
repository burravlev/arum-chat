const chats = document.getElementById('chats');

//add chat to chat menu
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
    user.appendChild(document.createTextNode(chat.companion));

    let lastMag = document.createElement('div');
    lastMag.classList.add('last-msg');
    lastMag.appendChild(document.createTextNode('last message'));

    chatInfo.appendChild(user);
    chatInfo.appendChild(lastMag);

    item.appendChild(avatar);
    item.appendChild(chatInfo);
    chats.appendChild(item);
}

fetch('/api/v1/users/alina')
    .then(response => response.json())
    .then(data => {
        console.log(data);
        console.log(data.chats);
        for (let chat  of data.chats) {
            chatPreview(chat);
            console.log(chat);
        }
    });
