function addUserValue() {
	var first = prompt("prompt - Please enter your f  name")
	var last = prompt("prompt - Please enter your l name")
	var user = prompt("prompt - Please enter your user")
	var pass = prompt("prompt - Please enter your pass")
	const
	data = {
		"fn" : first,
		"ln" : last,
		"un" : user,
		"ps" : pass
	}

	var htp = new XMLHttpRequest();

	htp.onreadystatechange = function() {

		if (htp.readyState == 4) {

			const
			response = JSON.parse(htp.responseText);

			if (response.status) {

				getUser();

			} else { 
				alert(response.massage);
			}

		}

	}

	htp.open('post', "http://localhost:7071/user", true);
	htp.setRequestHeader("Content-type", "application/json");
	htp.send(JSON.stringify(data));
}

function getUser() {

	var htp = new XMLHttpRequest();
	let
	table = document.getElementById("table-content");
	htp.onreadystatechange = function() {
		if (htp.readyState == 4) {
			var jsn = JSON.parse(htp.responseText);

			for (var i = 0; i < jsn.length; i++) {
				var ob = jsn[i];

				var fn = ob.firstName;
				var ln = ob.lastName;
				var us = ob.loginvo.userName;
				var ps = ob.loginvo.passWord;

				let
				row = table.insertRow(i + 1);
				let
				cell1 = row.insertCell(0);
				let
				cell2 = row.insertCell(1);
				let
				cell3 = row.insertCell(2);
				let
				cell4 = row.insertCell(3);
				let
				cell5 = row.insertCell(4);

				cell1.innerHTML = i + 1;
				cell2.innerHTML = fn;
				cell3.innerHTML = ln;
				cell4.innerHTML = us;
				cell5.innerHTML = ps;

			}

		}
	}

	htp.open('GET', "http://localhost:7071/user", true);
	htp.send();
}
function deleteUser(id) {
	var htp = new XMLHttpRequest();
	let
	table = document.getElementById("table-content");
	htp.onreadystatechange = function() {
		if (htp.readyState == 4) {
			var jsn = JSON.parse(htp.responseText);

			if (jsn.status) {
				getUser();
			} else {
				alert(jsn.message);
			}

		}
	}

	htp.open('DELETE', "http://localhost:7071/user/" + id, true);
	htp.send();
}

function del(d) {
	var l = d.parentNode.parentNode;

	var table = document.getElementById("table");

	table.deleteRow(l.rowIndex);
}
