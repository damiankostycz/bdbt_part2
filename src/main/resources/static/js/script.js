

function deleteConfirmation(){
    const btn = document.getElementById("confirmBtn")
    if(confirm("Czy na pewno chcesz usunąć wybrany element?")){
        btn.click();
        alert("Dane zostały usunięte")}
    else {
        alert("Anulowano usunięcie")
    }

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


const editButtons = document.getElementsByClassName("editBtn")
for(let x=0; x<editButtons.length; x++){
    editButtons[x].addEventListener("click", function(e){
        let temp = e.target.parentNode.parentNode;
        const list = temp.getElementsByTagName("td");
        const input = document.getElementsByClassName("getData");
        for (let i = 0; i < list.length; i++) {
            input[i].value = list[i].textContent;
            }
        });
    }

const getCellValue = (tr, idx) => tr.children[idx].innerText || tr.children[idx].textContent;

const comparer = (idx, asc) => (a, b) => ((v1, v2) =>
        v1 !== '' && v2 !== '' && !isNaN(v1) && !isNaN(v2) ? v1 - v2 : v1.toString().localeCompare(v2)
)(getCellValue(asc ? a : b, idx), getCellValue(asc ? b : a, idx));

document.querySelectorAll('th').forEach(th => th.addEventListener('click', (() => {
    const table = th.closest('table');
    const tbody = table.querySelector('tbody');
    Array.from(tbody.querySelectorAll('tr'))
        .sort(comparer(Array.from(th.parentNode.children).indexOf(th), this.asc = !this.asc))
        .forEach(tr => tbody.appendChild(tr) );})));





