define([], function() {
    App.Model._DocumentoModel = Backbone.Model.extend({
        defaults: {
 
		 'name' : '' ,  
		 'tipo' : '' ,  
		 'descripcion' : '' ,  
		 'autor' : ''        },
        initialize: function() {
        },
        getDisplay: function(name) {
         return this.get(name);
        }
    });

    App.Model._DocumentoList = Backbone.Collection.extend({
        model: App.Model._DocumentoModel,
        initialize: function() {
        }

    });
    return App.Model._DocumentoModel;
});