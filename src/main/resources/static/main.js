console.log("JS work");

$("#saveButtonCountry").click(function (event) {

    event.preventDefault();

    $.ajax({
        url: "/saveCountyAJAX",
        type: "POST",
        data: new FormData($("#formSaveCountry")[0]),
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
            console.log('ajax saved Country');
            alert('You created new country!');
        },
        error: function (err) {
            console.log(err);
            alert('Country already exist')
        }
    });
});

$("#updateButtonCountry").click(function (event) {

    event.preventDefault();

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
        data: JSON.stringify({id, nameCountry, dateOfCreation, politicalSystem, continent, capital, square, population}),
        processData: false,
        contentType: 'application/json',
        cache: false,
        success: function () {
            console.log('ajax updated Country');
            alert('You updated country!');
        },
        error: function (err) {
            console.log(err);
            alert('Country already exist')
        }
    });
});

$("#searchButtonCountry").click(function (event) {
    event.preventDefault();
    let searchCountry = $("#politicalSystem").val().toUpperCase();
    let nameCountry = $("#nameCountrySearch").val().toUpperCase();
    let continent = $("#continent").val().toUpperCase();
    let politicalSystemInputArray = document.getElementsByName("nameCountry");
    for (i=0;i<politicalSystemInputArray.length;i++){
        let politicalSystemInput = politicalSystemInputArray[i];
        if (politicalSystemInput){
            if (politicalSystemInput.innerHTML.toUpperCase().indexOf(searchCountry)>-1 &&
                (politicalSystemInput.innerHTML.toUpperCase().indexOf(nameCountry)>-1)){
                politicalSystemInput.style.display=""
            }else {
                politicalSystemInput.style.display="none"
            }
        }
    }
});

$("#nameCountrySearch").keyup(function () {
    let SearchCountry = $("#nameCountrySearch").val().toUpperCase();
    let BlockInputArray = document.getElementsByName("nameCountry");
    for (i=0;i<BlockInputArray.length;i++){
        let BlockInput = BlockInputArray[i];
        if (BlockInput){
            if (BlockInput.innerHTML.toUpperCase().indexOf(SearchCountry)>-1){
                BlockInput.style.display=""
            }else {
                BlockInput.style.display="none";
            }
        }
    }
});









$("#saveButtonCity").click(function (event) {

    event.preventDefault();

    $.ajax({
        url: "/saveCityAJAX",
        type: "POST",
        data: new FormData($("#formSaveCity")[0]),
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
            console.log('ajax saved City');
            alert('You created new City!');
        },
        error: function (err) {
            console.log(err);
            alert('City already exist')
        }
    });
});

$("#updateButtonCity").click(function (event) {

    event.preventDefault();

    let id = $("#id").val();
    let nameCity = $("#nameCity").val();
    let dateOfCreation = $("#dateOfCreation").val();
    let population = $("#population").val();
    let history = $("#history").val();
    let nameCountry = $("#nameCountry").val();

    $.ajax({
        url: "/updateCityAJAX" + nameCountry,
        type: "POST",
        data: JSON.stringify({id, nameCity, dateOfCreation, population, history}),
        processData: false,
        contentType: 'application/json',
        cache: false,
        success: function () {
            console.log('ajax updated City');
            alert('You updated City');
        },
        error: function (err) {
            console.log(err);
            alert('City already exist')
        }
    });
});

$("#searchButtonCity").click(function (event) {
    event.preventDefault();
    let SearchCity = $("#nameCity").val().toUpperCase();
    let NameCityInputArray = document.getElementsByName("nameCity");
    for (i=0;i<NameCityInputArray.length;i++){
        let NameCityInput = NameCityInputArray[i];
        if (NameCityInput){
            if (NameCityInput.innerHTML.toUpperCase().indexOf(SearchCity)>-1){
                NameCityInput.style.display=""
            }else {
                NameCityInput.style.display="none"
            }
        }
    }
});

$("#nameCitySearch").keyup(function () {
    let SearchCity = $("#nameCitySearch").val().toUpperCase();
    let BlockInputArray = document.getElementsByName("nameCity");
    for (i=0;i<BlockInputArray.length;i++){
        let BlockInput = BlockInputArray[i];
        if (BlockInput){
            if (BlockInput.innerHTML.toUpperCase().indexOf(SearchCity)>-1){
                BlockInput.style.display=""
            }else {
                BlockInput.style.display="none";
            }
        }
    }
});









$("#saveButtonSight").click(function () {

    event.preventDefault();

    let nameSight = $("#nameSight").val();
    let type = $("#type").val();
    let minMoney = $("#minMoney").val();
    let description = $("#description").val();
    let nameCity = $("#nameCity").val();

    $.ajax({
        url: '/saveSightAJAX' + nameCity,
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({nameSight, type, minMoney, description}),
        success: function () {
            console.log('ajax saved Sight');
            alert('You created new Sight!');
        },
        error: function (err) {
            console.log(err);
            alert('Sight already exist')
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
    let nameCity = $("#nameCity").val();

    $.ajax({
        url: '/updateSightAJAX' + nameCity,
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({id, nameSight, type, minMoney, description}),
        success: function () {
            console.log('ajax update Sight');
            alert('You updated Sight!');
        },
        error: function (err) {
            console.log(err);
            alert('Sight already exist')
        }
    });
});








$("#saveButtonUniversity").click(function (event) {

    event.preventDefault();

    $.ajax({
        url: "/saveUniversityAJAX",
        type: "POST",
        data: new FormData($("#formSaveUniversity")[0]),
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
            console.log('ajax saved Universuty');
            alert('You created new University!');
        },
        error: function (err) {
            console.log(err);
            alert('University already exist')
        }
    });
});

$("#updateButtonUniversity").click(function () {

    event.preventDefault();

    let id = $("#id").val();
    let nameUniversity = $("#nameUniversity").val();
    let direction = $("#direction").val();
    let ownership = $("#ownership").val();
    let formOfTraining = $("#formOfTraining").val();
    let dateOfCreation = $("#dateOfCreation").val();
    let street = $("#street").val();
    let nameCity = $("#nameCity").val();
    $.ajax({
        url: '/updateUniversityAJAX'+nameCity,
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({id, nameUniversity, direction, ownership, formOfTraining, dateOfCreation, street}),
        success: function () {
            console.log('ajax update University');
            alert('You updated University!');
        },
        error: function (err) {
            console.log(err);
            alert('University already exist')
        }
    });
});