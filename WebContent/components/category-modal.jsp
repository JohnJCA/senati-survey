<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Agregar nueva categoría</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		  <div class="form-group">
		    <label for="exampleInputEmail1">Nombre</label>
		    <input type="text" id="categoryName" class="form-control" name="username" placeholder="Ingrese nombre" required>
		  </div>
		  <div class="form-group">
		    <label for="exampleFormControlTextarea1">Descripción</label>
		    <textarea style="resize: none;height: 126px" maxlength="200" class="form-control" id="categoryDescription"></textarea>
		  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button onclick="addCategory()" class="btn btn-primary" data-dismiss="modal">Guardar</button>
      </div>
    </div>
  </div>
</div>
<script>
function addCategory() {
	 let categoryName = document.getElementById('categoryName').value;
	 let categoryDescription = document.getElementById('categoryDescription').value;
	  $.post("SCategory", {
		categoryName: categoryName,
		categoryDescription: categoryDescription
	  }, function(data, status) {
		  fillCategorySelect();
	  });
}


</script>