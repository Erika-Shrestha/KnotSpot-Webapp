/**
 * 
 */

function openPanel() {
    document.getElementById("viewPanel").classList.add("open");
}

function closePanel() {
    document.getElementById("viewPanel").classList.remove("open");
}

const openBtn = document.getElementById('openCreate');
const modal_container_add = document.getElementById('modal-container-add');
const closeBtn = document.getElementById('closeCreate');

openBtn.addEventListener('click', () => {
    modal_container_add.classList.add('show');
});

closeBtn.addEventListener('click', () => {
    modal_container_add.classList.remove('show');
});

const modal_container_edit = document.getElementById('modal-container-edit');
const closeEditBtn = document.getElementById('closeEdit');

closeEditBtn.addEventListener('click', () => {
    modal_container_edit.classList.remove('show');
});