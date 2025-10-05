
function openAddModel(button){
	const user=button.getAttribute("data-user");
	console.log(user);
	if(user){
		document.getElementById("addProductModal").style.display="flex";
	}else{
		showAlert("please login to add product");
	}
}
function closeModal(){
	document.getElementById("addProductModal").style.display="none";
}
//alert message
function showAlert(message, duration = 3000) {
    const alertDiv = document.getElementById("alertMessage");
    alertDiv.textContent = message;
    alertDiv.style.display = "block";

    setTimeout(() => {
        alertDiv.style.display = "none";
    }, duration);
}



// Open modal from button click
function openEditModalFromButton(button) {
	const user=button.getAttribute("data-user");
    const id = button.dataset.id;
    const name = button.dataset.name;
    const price = button.dataset.price;
    const description = button.dataset.description;
    const category = button.dataset.category;
    const imageUrl = button.dataset.image;
	
    // Fill modal fields
    document.getElementById("editProductId").value = id;
    document.getElementById("editName").value = name;
    document.getElementById("editPrice").value = price;
    document.getElementById("editDescription").value = description;
    document.getElementById("editCategory").value = category;
    document.getElementById("editImageUrl").value = imageUrl;

    // Show modal
	if(user){
		document.getElementById("editProductModal").style.display = "flex";
	}else{
		showAlert("please login to update product");
	}
}

// Close modal
function closeEditModal() {
    document.getElementById("editProductModal").style.display = "none";
}

// Handle form submission
document.getElementById("editProductForm").addEventListener("submit", function(e) {
    e.preventDefault();

    const id = document.getElementById("editProductId").value;
    const updatedProduct = {
        name: document.getElementById("editName").value,
        price: parseFloat(document.getElementById("editPrice").value),
        description: document.getElementById("editDescription").value,
        category: document.getElementById("editCategory").value,
        imageUrl: document.getElementById("editImageUrl").value
    };

    // PUT request to backend
    fetch(`/product/update/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(updatedProduct)
    })
    .then(response => response.json())
    .then(product => {
        // Update card instantly
        const card = document.querySelector(`.product-card[data-id='${id}']`);
        card.querySelector("h3").textContent = product.name;
        card.querySelector(".price span").textContent = product.price;
        card.querySelector(".category").textContent = product.category;
        card.querySelector("img").src = product.imageUrl;

        closeEditModal();
		showAlert("product updated successfully");
    })
    .catch(err => console.error("Error updating product:", err));
	
});

function deleteProduct(btn) {
	const productId= btn.getAttribute("data-id");
	const user=btn.getAttribute("data-user");
	if(user){
    fetch(`/products/delete/${productId}`, { method: "DELETE" })
      .then(response => response.json())
      .then(data => {
        if (data.success) {
          // ✅ Instantly remove the product card
          const card = document.querySelector(`.product-card[data-id='${productId}']`);
          if (card) card.remove();

          // ✅ Show success message
         showAlert("Product deleted successfully");
        } else {
          showAlert("product not deleted");
        }
      })
      .catch(() => alert("Error deleting product."));
	  }else{
		showAlert("please login to delete product");
	  }
}

