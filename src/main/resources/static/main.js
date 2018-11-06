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