function successfullyLogout(){
    alert("You have been successfully logged out");
}

function showLoginWindow() {
    // show the login window
    document.getElementById('login-window').style.display = 'block';
}

function hideLoginWindow() {
    // hide the login window
    document.getElementById('login-window').style.display = 'none';
}

function logout(){
    if(confirm("Czy na pewno chcesz się wylogować?"))
        alert("Zostałeś wylogowany")
}

function openForm() {
    document.getElementById("myForm").style.display = "block";
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
}

function deleteConfirmation(){
    if(confirm("Czy na pewno chcesz usunąć wybrany element?"))
        alert("Dane zostały usunięte")
}

function showHideRow() {
    const row = document.getElementById("myForm");
    const btn = document.getElementById("addButton");
    if (row.style.display === "none") {
        row.style.display = "table-row";
        btn.textContent = "Anuluj";
    } else {
        row.style.display = "none";
        btn.textContent = "Dodaj";
    }
}




