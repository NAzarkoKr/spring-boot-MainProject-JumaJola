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

// $("#updateButtonCountry").click(function (event) {
//
//     event.preventDefault(); /*блокує перезагрузку сторінки через form*/
//
//     $.ajax({
//         url: "/updateCountyAJAX",
//         type: "POST",
//         data: new FormData($("#formUpdateCountry")[0]),
//         processData: false,
//         contentType: false,
//         cache: false,
//         success: function () {
//             console.log('ajax update Country');
//         },
//         error: function (err) {
//             console.log(err);
//         }
//     });
// });




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
        success: function (response) {
            console.log('ajax saved Sight');
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