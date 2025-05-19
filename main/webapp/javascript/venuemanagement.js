/**
 * 
 */

/** the pop-up panel when view button is clicked to display selected venue */
function openPanel() {
    document.getElementById("viewPanel").classList.add("show");
}

/** the disappearance of pop-up panel when view button is clicked to display selected venue */
function closePanel() {
    document.getElementById("viewPanel").classList.remove("show");
}

/** the elements stored by id */
const openBtn = document.getElementById('openCreate');
const modal_container_add = document.getElementById('modal-container-add');
const closeBtn = document.getElementById('closeCreate');

/** event listener for buttons of view panel (view button) */
openBtn.addEventListener('click', () => {
    modal_container_add.classList.add('show');
});

/** event listener for buttons of view panel (view button) */
closeBtn.addEventListener('click', () => {
    modal_container_add.classList.remove('show');
});

/** the elements stored by id for edit panel*/
const modal_container_edit = document.getElementById('modal-container-edit');
const closeEditBtn = document.getElementById('closeEdit');

/** the elements stored by id to remove the edit panel */
closeEditBtn.addEventListener('click', () => {
    modal_container_edit.classList.remove('show');
});