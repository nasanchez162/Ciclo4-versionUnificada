define([], function() {
    App.Model._ItemMasterModel = Backbone.Model.extend({
     
    });

    App.Model._ItemMasterList = Backbone.Collection.extend({
        model: App.Model._ItemMasterModel,
        initialize: function() {
        }

    });
    return App.Model._ItemMasterModel;
    
});