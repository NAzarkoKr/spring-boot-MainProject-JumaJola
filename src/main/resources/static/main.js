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

// $("#saveButtonCountry").click(function () {
//     let nameCountry = $("#nameCountry").val();
//     let dateOfCreation = $("#dateOfCreation").val();
//     let politicalSystem = $("#politicalSystem").val();
//     let continent = $("#continent").val();
//     let capital = $("#capital").val();
//     let square = $("#square").val();
//     let population = $("#population").val();
//
//     console.log(dateOfCreation);
//     console.log(nameCountry);
//
//     $.ajax({
//         url:'/saveCountyAJAXform',
//         type:'POST',
//         contentType: 'application/json', /*тип який ми відправляємо*/
//         data: JSON.stringify({nameCountry,dateOfCreation,politicalSystem,continent,capital,square,population}), /*створили json об'єкт і відправили його за допомогою data(об'єкт з 3 парам)*/
//         success: function (response) {
//             console.log('ajax saved City');
//             console.log(response);
//         },
//         error: function (err) {
//             console.log(err);
//         }
//     });
//
// });

$("#saveButtonCountry").click(function (event) {

    event.preventDefault(); /*блокує перезагрузку сторінки через form*/

    let dateOfCreation = $("#dateOf").val();
    console.log(dateOfCreation);

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
$("#saveButtonUniversities").click(function (event) {

    event.preventDefault(); /*блокує перезагрузку сторінки через form*/

    let dateOfCreation = $("#dateOf").val();
    console.log(dateOfCreation);

    $.ajax({
        url: "/saveUniversitiesAJAXform",
        type: "POST",
        data: new FormData($("#formSaveUniversities")[0]),
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

$("#updateButtonUniversities").click(function (event) {

    event.preventDefault(); /*блокує перезагрузку сторінки через form*/

    $.ajax({
        url: "/updateUniversitiesAJAXform",
        type: "POST",
        data: new FormData($("#formUpdateUniversities")[0]),
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
            console.log('ajax update Universities');
        },
        error: function (err) {
            console.log(err);
        }
    });
});