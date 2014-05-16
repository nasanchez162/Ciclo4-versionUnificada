define([], function() {
    App.Model._ItemModel = Backbone.Model.extend({
        defaults: {
 
		 'cantidadItem' : '' ,  
		 'fechaExpiracion' : '' ,  
		 'name' : '' ,  
		 'precio' : '' ,  
		 'bodega' : '' ,  
		 'productoaId' : ''        },
        initialize: function() {
        },
        getDisplay: function(name) {
             if(name=='fechaExpiracion'){
                   var dateConverter = App.Utils.Converter.date;
                   return dateConverter.unserialize(this.get('fechaExpiracion'), this);
             }
			 if(name=='productoaId'){  
                 var value = App.Utils.getModelFromCache('productoComponent',this.get('productoaId'));
                 if(value) 
                 return value.get('name');
             }
         return this.get(name);
        }
    });

    App.Model._ItemList = Backbone.Collection.extend({
        model: App.Model._ItemModel,
        initialize: function() {
        }

    });
    return App.Model._ItemModel;
});