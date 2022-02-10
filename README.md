# spring-boot-mongodb-realm

#mongodb realm Https Endpoints

#Tutorials
https://docs.mongodb.com/realm/tutorial

#Select Http methos as Any_Http_Method 

// This function is the endpoint's request handler.
exports =  function(request, response) {
    
    const collection = context.services.get("mongodb-atlas").db("clouddb").collection("comment");
    let result;
    // create a new comment
    const createComment = ()=>{
        const {name,email,body} = EJSON.parse(request.body.text());
        result =  collection.insertOne({name,email,body});
    }
    // read all comment || spec comment
    const read = ()=>{
      try{
        const {email} = request.query;
        result =  collection.findOne({email});
      }
      catch(error){
        result =  collection.find().toArray();
      }
    }
    //update a exist comment
    const updateComment = ()=>{
      const {name,email,body} = EJSON.parse(request.body.text());
      result =  collection.updateOne({email},{name,email,body});
    }
    // delete a exist comment
    const deleteComment = ()=>{
      const {email} = request.query;
      result =  collection.deleteOne({email});
    }
    const {method} = request.query; //kick start
    const http_verb = method.toUpperCase();
    switch (http_verb) {
      case "POST":
        createComment();
        break;
      case "GET":
        read();
        break;
      case "PUT":
        updateComment();
        break;
      case "DELETE":
        deleteComment();
        break;
    }
  
    return result;
};
