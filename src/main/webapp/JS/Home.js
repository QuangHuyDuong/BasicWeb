viewPageByIndex(1)
// Check if users  login

	fetch('http://localhost:8080/Web/check_login')
    .then(response => response.json())
	.then(data => {
		console.log(data)
		if(data.responseStr =="Chua dang nhap") {
			
			document.getElementById("navbarnav").innerHTML += ` <li class="nav-item active">
                      <a class="nav-link" href="login.html">Login<span class="sr-only">(current)</span></a>
                    </li>`
		} else {
			
			if(data.responseStr =="La quan tri vien"){
				document.getElementById("navbarnav").innerHTML += ` <li class="nav-item active">
                      <a class="nav-link" href="ProductManager.html">Product Management<span class="sr-only">(current)</span></a>
                    </li>
					<li class="nav-item active">
                      <a class="nav-link" href="CustomerManager.html" >Customer Management<span class="sr-only">(current)</span></a>
                    </li>`
			
			}
			document.getElementById("navbarnav").innerHTML += ` <li class="nav-item active">
                      <a class="nav-link" href=""  onclick = "logout()">Log out<span class="sr-only">(current)</span></a>
                    </li>`
		
		}
	})
//Get page number
fetch('http://localhost:8080/Web/TotalPage')
.then(response => response.json())
.then(data => {
	var total = parseInt(data.index)
	var i = 1;
	while ( i <= total) {
		document.querySelector(".pagination").innerHTML += `<li class="page-item" onclick = "viewPageByIndex(${i})"><a class="page-link">${i}</a></li> `;
		i++;
	}
})


//////
function viewPageByIndex(index) {
    var pageIndex = {
        index : index
    }

fetch('http://localhost:8080/Web/ViewPageByIndex',{
    method: 'POST', 
    body: JSON.stringify(pageIndex), 
    headers:{
      'Content-Type': 'application/json'
    }
})
.then(response => response.json())
.then(data => {
    let html=""
    data.forEach(element => {
        html +=` <div class ="col-12 col-sm-6 col-md-4 bg-light">
                    Ma san pham : ${element.id}. 
					<br>
					Ten san pham : ${element.name}
                    <br>
                    <img src ="${element.img}" />
					<br>
					<button onclick = "addToCart('${element.id}','${element.name}')">Add to cart </button>
                 </div>`
	document.querySelector(".row").innerHTML = html
    });
	
})	
}

