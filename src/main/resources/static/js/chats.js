const chat = document.getElementById('chats');
let hasChats = false;

function noChats() {
    const noChats = document.createElement('div');
    noChats.classList.add('no-chats');
    noChats.appendChild(document.createTextNode('No chats yet...'));
    const main = document.getElementById('chats-main');
    if (!hasChats) {
        main.appendChild(noChats);
    }
}

