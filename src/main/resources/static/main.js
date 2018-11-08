console.log("JS work");

$("#saveButtonCountry").click(function (event) {
    event.preventDefault(); /*блокує перезагрузку сторінки через form*/

    $.ajax({
        url: "/saveCountyAJAX",
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
    let id = $("#id").val();
    let nameCountry = $("#nameCountry").val();
    let dateOfCreation = $("#dateOfCreation").val();
    let politicalSystem = $("#politicalSystem").val();
    let continent = $("#continent").val();
    let capital = $("#capital").val();
    let square = $("#square").val();
    let population = $("#population").val();
    $.ajax({
        url: "/updateCountyAJAX",
        type: "POST",
        data: JSON.stringify({id,nameCountry,dateOfCreation,politicalSystem,continent,capital,square,population}),
        processData: false,
        contentType: 'application/json',
        cache: false,
        success: function () {
            console.log('ajax update Country');
        },
        error: function (err) {
            console.log(err);
        }
    });
});





$("#saveButtonCity").click(function (event) {

    event.preventDefault(); /*блокує перезагрузку сторінки через form*/

    $.ajax({
        url: "/saveCityAJAX",
        type: "POST",
        data: new FormData($("#formSaveCity")[0]),
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
            console.log('ajax saved City');
        },
        error: function (err) {
            console.log(err);
        }
    });
});

$("#updateButtonCity").click(function (event) {

    event.preventDefault(); /*блокує перезагрузку сторінки через form*/

    let id = $("#id").val();
    let nameCity = $("#nameCity").val();
    let dateOfCreation = $("#dateOfCreation").val();
    let population = $("#population").val();
    let history = $("#history").val();
    $.ajax({
        url: "/updateCityAJAX",
        type: "POST",
        data: JSON.stringify({id,nameCity,dateOfCreation,population,history}),
        processData: false,
        contentType: 'application/json', /*тип який ми відправляємо*/
        cache: false,
        success: function () {
            console.log('ajax update City');
        },
        error: function (err) {
            console.log(err);
        }
    });
});





$("#saveButtonSight").click(function () {
    let nameSight = $("#nameSight").val();
    let type = $("#type").val();
    let minMoney = $("#minMoney").val();
    let description = $("#description").val();

    $.ajax({
        url:'/saveSightAJAX',
        type:'POST',
        contentType: 'application/json', /*тип який ми відправляємо*/
        data: JSON.stringify({nameSight,type,minMoney,description}), /*створили json об'єкт і відправили його за допомогою data(об'єкт з 3 парам)*/
        success: function () {
            console.log('ajax saved Sight');
        },
        error: function (err) {
            console.log(err);
        }
    });
});

$("#updateButtonSight").click(function () {

    event.preventDefault();

    let id = $("#id").val();
    let nameSight = $("#nameSight").val();
    let type = $("#type").val();
    let minMoney = $("#minMoney").val();
    let description = $("#description").val();

    $.ajax({
        url:'/updateSightAJAX',
        type:'POST',
        contentType: 'application/json', /*тип який ми відправляємо*/
        data: JSON.stringify({id,nameSight,type,minMoney,description}), /*створили json об'єкт і відправили його за допомогою data(об'єкт з 3 парам)*/
        success: function (response) {
            console.log('ajax update Sight');
            console.log(response);
        },
        error: function (err) {
            console.log(err);
        }
    });
});





$("#saveButtonUniversity").click(function (event) {

    event.preventDefault(); /*блокує перезагрузку сторінки через form*/

    $.ajax({
        url: "/saveUniversityAJAX",
        type: "POST",
        data: new FormData($("#formSaveUniversity")[0]),
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
            console.log('ajax saved University');
        },
        error: function (err) {
            console.log(err);
        }
    });
});