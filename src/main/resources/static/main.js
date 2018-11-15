console.log("JS work");


$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function (e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});


$("#saveButtonCountry").click(function (event) {
    event.preventDefault();
    let date = Date;
    let nameCountry = $("#nameCountry").val();
    let dateOfCreation = $("#dateOfCreation").val();
    let capital = $("#capital").val();
    let square = $("#square").val();
    let population = $("#population").val();
    let reg = /^[A-Za-z ]*$/;
    if (nameCountry != "" &&
        capital != "" &&
        square > 0 &&
        population > 0 &&
        reg.test(capital) &&
        reg.test(nameCountry)) {
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
    } else {
        alert('Something Wrong')
    }

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
    let reg = /^[A-Za-z]*$/;
    if (nameCountry != "" &&
        capital != "" &&
        square > 0 &&
        population > 0 &&
        reg.test(capital) &&
        reg.test(nameCountry)) {
        $.ajax({
            url: "/updateCountyAJAX",
            type: "POST",
            data: JSON.stringify({
                id,
                nameCountry,
                dateOfCreation,
                politicalSystem,
                continent,
                capital,
                square,
                population
            }),
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
    } else {
        alert('Something Wrong')
    }

});

// $("#searchButtonCountry").click(function (event) {
//     event.preventDefault();
//     let searchCountry = $("#politicalSystem").val().toUpperCase();
//     let nameCountry = $("#nameCountrySearch").val().toUpperCase();
//     let politicalSystemInputArray = document.getElementsByName("nameCountry");
//     for (i=0;i<politicalSystemInputArray.length;i++){
//         let politicalSystemInput = politicalSystemInputArray[i];
//         if (politicalSystemInput){
//             if (politicalSystemInput.innerHTML.toUpperCase().indexOf(searchCountry)>-1 &&
//                 (politicalSystemInput.innerHTML.toUpperCase().indexOf(nameCountry)>-1)){
//                 politicalSystemInput.style.display=""
//             }else {
//                 politicalSystemInput.style.display="none"
//             }
//         }
//     }
// });
// $("#searchButtonCountry").click(function (event) {
//     event.preventDefault();
//     // let politicalSystem = $("#politicalSystem").val().toUpperCase();
//     let nameCountry = $("#nameCountrySearch").val();
//     // let continent = $("#continent").val().toUpperCase();
//     console.log(nameCountry)
//     $.ajax({
//         url: "SearchCountryAJAX" + nameCountry,
//         type: "GET",
//         data: false,
//         processData: false,
//         contentType: false,
//         cache: false,
//         success: function () {
//             console.log('Search');
//         },
//         error: function (err) {
//             console.log(err);
//         }
//     })
//
// })
//__________________________________________________________________--
$("#searchButtonCountry").click(function (event) {
    event.preventDefault();
    let nameCountry = $("#nameCountrySearch").val();
    console.log(nameCountry);
    let NameCountryInputArray = document.getElementsByName("nameCountrySearch");
    $.ajax({
        url: "/searchButtonCountry/" + nameCountry,
        type: "GET",
        data: null,
        processData: false,
        contentType: false,
        cache: false,
        success: function (country) {
            for (i = 0; i < NameCountryInputArray.length; i++) {
                let NameCountryInput = NameCountryInputArray[i];
                if (NameCountryInput) {
                    if (NameCountryInput.innerHTML.toUpperCase().indexOf(country) > -1) {
                        NameCountryInput.style.display = ""
                    } else {
                        NameCountryInput.style.display = "none"
                    }
                }
            }
            console.log(country);
            console.log('ajax search');
        },
        error: function (err) {
            console.log(err);
        }
    })
})
//___________________________________________________________________


// $("#nameCountrySearch").keyup(function () {
//     let SearchCountry = $("#nameCountrySearch").val().toUpperCase();
//     let BlockInputArray = document.getElementsByName("nameCountry");
//     for (i=0;i<BlockInputArray.length;i++){
//         let BlockInput = BlockInputArray[i];
//         if (BlockInput){
//             if (BlockInput.innerHTML.toUpperCase().indexOf(SearchCountry)>-1){
//                 BlockInput.style.display=""
//             }else {
//                 BlockInput.style.display="none";
//             }
//         }
//     }
// });
$("#saveButtonCity").click(function (event) {
    event.preventDefault();
    let nameCity = $("#nameCity").val();
    let dateOfCreation = $("#dateOfCreation").val();
    let population = $("#population").val();
    let history = $("#history").val();
    let reg = /^[A-Za-z ]*$/;

    let nameCountry = $("#nameCountry").val();
    if (nameCity != "" &&
        population > 0 &&
        history != "" &&
        nameCountry != "" &&
        reg.test(nameCity) &&
        reg.test(nameCountry)) {
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
    } else {
        alert('Something Wrong')
    }
});
$("#updateButtonCity").click(function (event) {

    event.preventDefault();

    let id = $("#id").val();
    let nameCity = $("#nameCity").val();
    let dateOfCreation = $("#dateOfCreation").val();
    let population = $("#population").val();
    let history = $("#history").val();
    let nameCountry = $("#nameCountry").val();
    let reg = /^[A-Za-z  ]*$/;
    if (nameCity != "" &&
        population > 0 &&
        history != "" &&
        nameCountry != "" &&
        reg.test(nameCity) &&
        reg.test(nameCountry)) {
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
    } else {
        alert('Something Wrong')
    }
});

$("#searchButtonCity").click(function (event) {
    event.preventDefault();
    let SearchCity = $("#nameCity").val().toUpperCase();
    let NameCityInputArray = document.getElementsByName("nameCity");
    for (i = 0; i < NameCityInputArray.length; i++) {
        let NameCityInput = NameCityInputArray[i];
        if (NameCityInput) {
            if (NameCityInput.innerHTML.toUpperCase().indexOf(SearchCity) > -1) {
                NameCityInput.style.display = ""
            } else {
                NameCityInput.style.display = "none"
            }
        }
    }
});

$("#nameCitySearch").keyup(function () {
    let SearchCity = $("#nameCitySearch").val().toUpperCase();
    let BlockInputArray = document.getElementsByName("nameCity");
    for (i = 0; i < BlockInputArray.length; i++) {
        let BlockInput = BlockInputArray[i];
        if (BlockInput) {
            if (BlockInput.innerHTML.toUpperCase().indexOf(SearchCity) > -1) {
                BlockInput.style.display = ""
            } else {
                BlockInput.style.display = "none";
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
    let reg = /^[A-Za-z ]*$/;
    if (nameSight != "" &&
        type != "" &&
        minMoney > 0 &&
        description != "" &&
        nameCity != "" &&
        reg.test(nameCity) &&
        reg.test(description) &&
        reg.test(nameCity)) {
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
    } else {
        alert('Something Wrong')
    }
});

$("#updateButtonSight").click(function () {
    event.preventDefault();

    let id = $("#id").val();
    let nameSight = $("#nameSight").val();
    let type = $("#type").val();
    let minMoney = $("#minMoney").val();
    let description = $("#description").val();
    let nameCity = $("#nameCity").val();
    let reg = /^[A-Za-z ]*$/;
    if (nameSight != "" &&
        type != "" &&
        minMoney > 0 &&
        description != "" &&
        nameCity != "" &&
        reg.test(nameSight) &&
        reg.test(description) &&
        reg.test(nameCity)) {
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
    } else {
        alert('Something Wrong')
    }
});


$("#saveButtonUniversity").click(function (event) {
    event.preventDefault();
    let nameUniversity = $("#nameUniversity").val();
    let direction = $("#direction").val();
    let ownership = $("#ownership").val();
    let formOfTraining = $("#formOfTraining").val();
    let dateOfCreation = $("#dateOfCreation").val();
    let street = $("#street").val();
    let nameCity = $("#nameCity").val();
    let reg = /^[A-Za-z _]*$/;
    if (nameUniversity != "" &&
        direction != "" &&
        ownership != "" &&
        formOfTraining != "" &&
        street != "" &&
        nameCity != "" &&
        reg.test(nameUniversity) &&
        reg.test(direction) &&
        reg.test(street) &&
        reg.test(nameCity) &&
        reg.test(formOfTraining) &&
        reg.test(ownership)) {
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
    } else {
        alert('Something Wrong')
    }
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
    let reg = /^[A-Za-z _]*$/;
    if (nameUniversity != "" &&
        direction != "" &&
        ownership != "" &&
        formOfTraining != "" &&
        street != "" &&
        nameCity != "" &&
        reg.test(nameUniversity) &&
        reg.test(direction) &&
        reg.test(street) &&
        reg.test(nameCity) &&
        reg.test(formOfTraining) &&
        reg.test(ownership)) {
        $.ajax({
            url: '/updateUniversityAJAX' + nameCity,
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
    } else {
        alert('Something Wrong')
    }
});

$("#registrationButton").click(function () {
    let log = document.getElementById('login');
    let reg = document.getElementById('register');
    reg.style.display = "block";
    log.style.display="none";
});
$("#loginButton").click(function () {
    let log = document.getElementById('login');
    let reg = document.getElementById('register');
    log.style.display="block";
    reg.style.display = "none";
});