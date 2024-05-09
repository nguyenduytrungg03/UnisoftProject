
  $(document).ready(function() {
    $("#bodyTable").on('blur', '[contenteditable=true]', function() {
    let cell = $(this);
    let classList = cell.attr('class');
    let classArray = classList.split(" ");
    let columnName = classArray[0];
    let type = '';
    if (columnName === 'codeProduct' || columnName === 'nameProduct') {
        type = (columnName === 'codeProduct') ? 'name' : 'code';
        fillDataProduct(cell, type);
        console.log(fillDataProduct);
    } else if (columnName === 'phoneNumberCustomer' || columnName === 'nameCustomer') {
        type = (columnName === 'phoneNumberCustomer') ? 'name' : 'phone';
        fillDataCustomer(cell, type);
    }
   });
   });
    //autoFill sản phẩm
    async  function fillDataProduct(cellData, type) {
    const data = $(cellData).text().trim();
    if(type == 'code'){
        cellInsert = $(cellData).closest("tr").find('.codeProduct');
    } else {
        cellInsert = $(cellData).closest("tr").find('.nameProduct');
    } try {
        const response = await $.ajax({
        url: `http://localhost:8081/api/product/${type}`,
        method: "GET",
        data: {
            [type === 'name' ? 'codeProduct' : 'nameProduct']: data
        }
    });
    cellInsert.text(response);
    } catch(error) {
    console.error('Error:', error);
    }
    }
    //autoFill Khách hàng
    async function fillDataCustomer(cellData, type) {
    const data = $(cellData).text().trim();
	if(type == 'phone'){
		cellInsert = $(cellData).closest("tr").find('.phoneNumberCustomer');
	} else {
		cellInsert = $(cellData).closest("tr").find('.customerName');
	}
	try {
	        const response = await $.ajax({
	        url: `http://localhost:8081/api/customer/${type}`,
	        method: "GET",
	        data: {
	            [type === 'name' ? 'phoneNumberCustomer' : 'customerName']: data
	        }
	    });
	    cellInsert.text(response);
    } catch (error) {
        console.error('Error:', error);
    }
}