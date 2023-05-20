checkLogin()
enableButtons(false, true)
if (getRole() !== 'ADMIN') {
	window.location = '/'
}

const submitBtn = document.getElementById('submit')
submitBtn.addEventListener('click', async () => {
	const [ok, data, apiErr] = await doFetch(
		() => fetch('/api/products', {
			method: 'POST',
			body: JSON.stringify({
				name: document.getElementById('name').value,
				price: document.getElementById('price').value,
				unitPrice: document.getElementById('unit-price').value,
				unitsInStock: document.getElementById('units-in-stock').value,
				description: document.getElementById('description').value,
				manufacturer: document.getElementById('manufacturer').value,
				category: document.getElementById('category').value,
				productCondition: getCondition(),
				imageFile: '/img/huawei.jpg'
			}),
			headers: {
				'Content-Type': 'application/json',
				'Authorization': 'Bearer ' + getToken()
			}
		})
	)
  if (!ok) {
    handleError(data)
		return
  }
	window.location = '/'
})

function getCondition() {
	const cn = document.getElementById('cn')
	const co = document.getElementById('co')
	const cr = document.getElementById('cr')
	if (cn.checked) {
		return 'NEW'
	}
	if (co.checked) {
		return 'OLD'
	}
	if (cr.checked) {
		return 'REFURBISHED'
	}
	return null
}
