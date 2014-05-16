define(['model/_itemMasterModel'], function() { 
    App.Model.ItemMasterModel = App.Model._ItemMasterModel.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('item-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.ItemModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.itemEntity,options);
            }
        }
    });

    App.Model.ItemMasterList = App.Model._ItemMasterList.extend({
        model: App.Model.ItemMasterModel
    });

    return  App.Model.ItemMasterModel;

});