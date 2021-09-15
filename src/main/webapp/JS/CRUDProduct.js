fetch('http://localhost:8080/Web/TotalPage')
    .then(response => response.json())
    .then(data => {
        var total = parseInt(data.index)
        var i = 1;
        while (i <= total) {
            document.querySelector(".pagination").innerHTML += `<li class="page-item" onclick = "viewPageByIndex(${i})"><a class="page-link">${i}</a></li> `;
            i++;
        }
    })
viewPageByIndex(1)

/// all funtions below

function viewPageByIndex(index) {
    var pageIndex = {
        index: index
    }

    fetch('http://localhost:8080/Web/ViewPageByIndex', {
        method: 'POST',
        body: JSON.stringify(pageIndex),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
            let html = ""
            data.forEach(element => {
                html += `	<tr id ='${element.id}'>
                                    <td>${element.id}</td>
                                    <td class = "${element.id}">${element.name}</td>
                                    <td>
		
	                                <button onclick = "doDelete('${element.id}','${element.name}')">DELETE</button>
                                    <button onclick ="showFormUpdate('${element.id}_form')">Update</button>
                                    </td>
                                    </tr>
								<tr>
								 <div class = "updateForm"   id = "${element.id}_form">
                                    Update product name <input type="text" name="" id="${element.id}_update">
	                                <button onclick="doUpdate('${element.id}')">Confirm</button>
                                    </div>
								</tr>
                                   `
                document.querySelector(".content").innerHTML = html
            });

        })
}





function doDelete(id, name) {

    var con = confirm("Are you sure to delete this product??")
    if (!con) {

    } else {
        fetch("http://localhost:8080/Web/admin/CRUDProduct",
            {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: "DELETE",
                body: JSON.stringify({
                    id: id,
                    name: name
                })
            })

    }
    document.getElementById(id).remove()
  

}


function showFormUpdate(id) {
   if( document.getElementById(id).style.display =="none" ){
    document.getElementById(id).style.display = "inline-block"
   } else {
    document.getElementById(id).style.display = "none"
   }
   
   
    
}
function doUpdate(id) {
    var content = document.getElementById(id+"_update").value
    fetch("http://localhost:8080/Web/admin/CRUDProduct",
            {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: "PUT",
                body: JSON.stringify({
                    id: id,
                    name : content
                })
            })
    alert("Cap nhat thanh cong! ")
    document.querySelector("." + id).innerHTML = content
}