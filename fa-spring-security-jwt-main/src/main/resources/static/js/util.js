function getToken() {
	return localStorage.getItem('access-token')
}

function getRole() {
	return localStorage.getItem('role')
}

function isLoggedIn() {
	return getToken() !== null && getRole() !== null
}

function checkLogin() {
	if (!isLoggedIn()) {
		window.location = '/login.html'
	}
}

function logout() {
	localStorage.removeItem('access-token')
	localStorage.removeItem('role')
	window.location = '/login.html'
}

async function doFetch(fetchFunc) {
  try {
    const res = await fetchFunc()
		let data
		try {
    	data = await res.json()
		} catch {
			data = null
		}
    return res.ok
			? [true, data, null]
			: [false, data, null]
  } catch (err) {
		console.log(err);
    return [false, null, err]
  }
}

function handleError(err) {
	if (!err) {
		alert('Unknown error')
		return
	}
	alert(err.message)
	if (err.status === 401 || err.status === 403) {
		logout()
	}
}

function enableButtons(createProductBtn, logoutBtn) {
	if (createProductBtn) {
		document.getElementById('create-product').hidden = false
	}
	if (logoutBtn) {
		document.getElementById('logout').hidden = false
	}
}
