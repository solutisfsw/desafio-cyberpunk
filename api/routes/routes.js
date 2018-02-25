var appRouter = function(app) {
    
    app.get("/", function(req, res) {
        res.send("Olá Cyperpunk");
    });

    app.get("/account", function(req, res){
        var accountMock = {
            "username": "cyber01",
            "password": "1234",
        }
        if (!req.query.username){
            return res.send({"status":"error", "message":"missing username"});
        }else if(req.query.username != accountMock.username){
            return res.send({"status": "error", "message":"wrong username"});
        }else{
            return res.send(accountMock);
        }
    });

    app.post("/account", function(req, res){
        if(!red.body.username || !req.body.password){
            return res.sen({"status": "error", "message": "missing parameter"});
        }else{
            return res.send(req.body);
        }
    });

}

module.exports = appRouter;