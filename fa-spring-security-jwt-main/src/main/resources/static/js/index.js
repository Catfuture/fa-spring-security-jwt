checkLogin()
enableButtons(getRole() === 'ADMIN', true)

doFetch(
	() => fetch('/api/products', {
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
		handleError(data)
		return
	}
	console.log(data);

	const box = document.getElementById('box')
	for (const item of data) {
		const html = `
			<div class="col-lg-3 col-md-4 col-sm-6 col-12 my-3">
				<div class="card px-2 ">
						<div class="card-body">
								<h5 class="card-title">${item.name}</h5>
						</div>
						<img src="${item.imageFile}" class="card-img-top" alt="...">
						<p>${item.description}</p>
						<p>${item.price} ${item.unitPrice}</p>
						<p>${item.unitsInStock} units in stock</p>

						<div class="card-body">
						<a href="/product.html?id=${item.id}">
								<button type="button" class="btn btn-info"><i class="fa-solid fa-circle-info"></i>
										Details</button>
										</a>
								<button type="button" class="btn btn-warning"><i class="fa-solid fa-cart-shopping"></i>
										Order Now</button>
						</div>
				</div>
		</div>`

		box.insertAdjacentHTML( 'beforeend', html);
	}
})
