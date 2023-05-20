checkLogin()

const id = getSelectedId()
if (!id) {
	window.location = '/'
}

doFetch(
	() => fetch('/api/products/' + id, {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json',
			'Authorization': 'Bearer ' + getToken()
		}
	})
)
.then(result => {
	const [ok, data, apiErr] = result
	if (!ok) {
		window.location = '/'
		return
	}
	document.getElementById('name').innerText = data.name
	document.getElementById('description').innerText = data.description
	document.getElementById('manufacturer').innerText = data.manufacturer
	document.getElementById('category').innerText = data.category
	document.getElementById('units-in-stock').innerText = data.unitsInStock
	document.getElementById('price').innerText = data.price
	document.getElementById('unit-price').innerText = data.unitPrice
	document.getElementById('img').src = data.imageFile
})

function getSelectedId() {
	const urlSearchParams = new URLSearchParams(window.location.search);
	const queryStringMap = Object.fromEntries(urlSearchParams.entries());
	return queryStringMap.id
}
