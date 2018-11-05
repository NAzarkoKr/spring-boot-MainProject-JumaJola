console.log("JS work");

$("#saveButtonCity").click(function () {
    let nameCity = $("#nameCity").val();
    let dateOfCreation = $("#dateOfCreation").val();
    let population = $("#population").val();
    let history = $("#history").val();

    $.ajax({
        url:'/saveCityAJAX',
        type:'POST',
        contentType: 'application/json', /*тип який ми відправляємо*/
        data: JSON.stringify({nameCity,dateOfCreation,population,history}), /*створили json об'єкт і відправили його за допомогою data(об'єкт з 3 парам)*/
        success: function (response) {
            console.log('ajax saved City');
            console.log(response);
        },
        error: function (err) {
            console.log(err);
        }
    });
});



$("#saveButtonCountry").click(function (event) {

    event.preventDefault(); /*блокує перезагрузку сторінки через form*/

    $.ajax({
        url: "/saveCountyAJAXform",
        type: "POST",
        data: new FormData($("#formSaveCountry")[0]),
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
            console.log('ajax saved Country');
        },
        error: function (err) {
            console.log(err);
        }
    });
});

$("#updateButtonCountry").click(function (event) {

    event.preventDefault(); /*блокує перезагрузку сторінки через form*/

    $.ajax({
        url: "/updateCountyAJAXform",
        type: "POST",
        data: new FormData($("#formUpdateCountry")[0]),
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
            console.log('ajax update Country');
        },
        error: function (err) {
            console.log(err);
        }
    });
});