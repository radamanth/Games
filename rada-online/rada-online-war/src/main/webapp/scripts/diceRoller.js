$(document).ready(function () {

    var rollViewModel = {
        rolls: ko.observableArray([])
    }

    function rollTheDice(evt) {

        evt.preventDefault();
    };

    function addOneDiceRoll() {
        var newIndex = rollViewModel.rolls().length + 1;
        var newRoll = ko.observable(new Roll('Roll ' + newIndex, 'roll' + newIndex + 'Title', 'roll' + newIndex + 'Title', 'roll' + newIndex, 'roll' + newIndex, 'nbRoll' + newIndex, 'nbRoll' + newIndex));
        rollViewModel.rolls.push(newRoll);
        $('div[data-role="page"]').trigger('refresh');
    }

    function addDice(evt) {
        addOneDiceRoll();
        evt.preventDefault();
    }

    var RequestedRoll = function (p_comment, p_nbRoll, p_dice, p_results) {
        this.nbRoll = ko.observable(p_nbRoll);
        this.dice = ko.observable(p_dice);
        this.comment = ko.observable(p_comment);
        // devrait être une Array
        if (Array.isArray(p_results)) {
            this.results = ko.observable(p_results);
        } else
            this.results = ko.observable([]);
    };


    var Roll = function (title, rollTitleName, rollTitleId, rollName, rollId, nbRollsName, nbRollsId) {
        this.title = ko.observable(title);
        this.rollTitleName = ko.observable(rollTitleName);
        this.rollTitleId = ko.observable(rollTitleId);
        this.rollName = ko.observable(rollName);
        this.rollId = ko.observable(rollId);
        this.nbRollsName = ko.observable(nbRollsName);
        this.nbRollsId = ko.observable(nbRollsId);
//        this.rollData = ko.observable(new RequestedRoll('Comment'+this.title, 4, '1D20+13', []));
        this.nbRoll = ko.observable(4);
        this.dice = ko.observable('1D20+13');
        this.comment = ko.observable('MyComment');
        this.results = ko.observable([]);

    };

    addOneDiceRoll();
    /*addOneDiceRoll();
    addOneDiceRoll();*/


    $('#btnRoll').bind("click submit", rollTheDice);
    $('#adddices').bind("click", addDice);


    ko.applyBindings(rollViewModel);

    $('div[data-role="page"]').trigger('refresh');


});