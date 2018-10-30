console.log("JS work");

$("#saveButtonCountry").click(function () {

    let nameCountry = $("#nameCountry").val();
    let dateOfCreation = $("#dateOfCreation").val();
    let politicalSystem = $("#politicalSystem").val();
    let continent = $("#continent").val();
    let capital = $("#capital").val();
    let square = $("#square").val();
    let population = $("#population").val();

    $.ajax({
        url:'/saveCountyAJAX',
        type:'POST',
        contentType: 'application/json', /*тип який ми відправляємо*/
        data: JSON.stringify({nameCountry,dateOfCreation,politicalSystem,continent,capital,square,population}), /*створили json об'єкт і відправили його за допомогою data(об'єкт з 3 парам)*/
        success: function (response) {
            console.log('ajax saved Country');
            console.log(response);
        },
        error: function (err) {
            console.log(err);
        }
    });

});


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


$("#btn").click(function (event) {

    event.preventDefault(); /*блокує перезагрузку сторінки через form*/

    $.ajax({
        url: "/saveCountyAJAXform",
        type: "POST",
        data: new FormData($("#f1")[0]),
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
            console.log('ajax saved Country!!!!!!!!!!!!!!');
        },
        error: function (err) {
            console.log(err);
        }
    });

});