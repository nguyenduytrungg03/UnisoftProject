
    let arrayPage = JSON.parse(localStorage.getItem("arrayPage")) || [];
    let currentPage = parseInt(new URLSearchParams(window.location.search).get('page')) || 1;
    let orderArr = [];
    let orderArrIndex = arrayPage.findIndex(order => order.page === currentPage);
    if (orderArrIndex !== -1) {
	        orderArr = arrayPage[orderArrIndex].orderArr;
    }
    // Mảng lưu trữ các đơn hàng đã sửa đổi
    let editedOrders = JSON.parse(localStorage.getItem("editedOrders")) || [];
    function checkChangeValue(cell){
       let $currentRow 	= $(cell).closest("tr");
	   let idOrder      = $currentRow.find(".idOrder").text();
	   let codeProduct  = $currentRow.find(".codeProduct").text();
	   let nameProduct  = $currentRow.find(".nameProduct").text();
	   let quantity     = $currentRow.find(".quantity").text();
	   let phoneNumberCustomer = $currentRow.find(".phoneNumberCustomer").text();
	   let nameCustomer = $currentRow.find(".nameCustomer").text();
	   //lấy giá trị ẩn
	   let codeProductHidden         =  $currentRow.find(".codeProductHidden").text();
	   let nameProductHidden         =  $currentRow.find(".nameProductHidden").text();
       let quantityHidden            =  $currentRow.find(".quantityHidden").text();
       let phoneNumberCustomerHidden =  $currentRow.find(".phoneNumberCustomerHidden").text();
       let nameCustomerHidden        =  $currentRow.find(".nameCustomerHidden").text();
       let orderNow ={
              idOrder             : idOrder,
              codeProduct         : codeProduct,
              nameProduct         : nameProduct,
              quantity            : quantity,
              phoneNumberCustomer : phoneNumberCustomer,
              nameCustomer        : nameCustomer
       };
       let orderHidden= {
              idOrder             : idOrder,
              codeProduct         : codeProductHidden,
              nameProduct         : nameProductHidden,
              quantity            : quantityHidden,
              phoneNumberCustomer : phoneNumberCustomerHidden,
              nameCustomer        : nameCustomerHidden
       };
       let existingPage = arrayPage.findIndex(order => order.page === currentPage);


    }