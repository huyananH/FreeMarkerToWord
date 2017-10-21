function subhandler(act) {
    $("input[name='action']").val(act);
}


$("#parentId").change(function () {
    var selectedParentId = $(this).children('option:selected').val();
    $.get("/customer/pay/table", {parentId: selectedParentId}).done(function (data) {
        $('#newestpaylist').html(data);
    });
});