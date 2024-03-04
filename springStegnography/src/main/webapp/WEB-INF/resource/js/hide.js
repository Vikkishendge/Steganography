	
	 document.addEventListener('DOMContentLoaded', function() {
         var imageInput = document.getElementById('Hide');
         var selectedImage = document.getElementById('Selected_img');

         imageInput.addEventListener('change', function() {
             var file = this.files[0]; // Get the selected file
             if (file) {
                 var reader = new FileReader(); // Create a file reader
                 reader.onload = function(e) {
                     selectedImage.src = e.target.result; // Set the source of the image
                     selectedImage.style.display = 'block'; // Show the image
                 };
                 reader.readAsDataURL(file); // Read the file as a data URL
             }
         });
     });