import Models.Hero;
import Models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
       /* get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Squad> squads = Squad.getAll();
            List<Hero> heroes = Hero.getAll();
            model.put("Heroes",heroes);
            model.put("squads",squads);
            return modelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String  name = request.queryParams(":name");
            int size = Integer.parseInt(request.queryParams(":id"));
            String cause = request.queryParams(":cause");
            Squad  squad1  = new Squad(name,size,cause);
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

        post("postNewSquad",(request, response) -> {
            Map<String, Object>model =  new HashMap<>();
            String name= request.queryParams(":name");
            int age = Integer.parseInt(request.queryParams(":id"));
            String power = request.queryParams(":specialPower");
            String weakness = request.queryParams((":weakness"));
            int SquadHero = Integer.parseInt(request.queryParams(":heroes"));
            Squad newsquad =Squad.findById(SquadHero);
            Hero hero = new Hero(name,age,power,weakness);
            newsquad.addHeroToSquad(hero);
            response.redirect("/");
            return  null;
        },new HandlebarsTemplateEngine());

        get("/squad/:id", (request, response) -> {
           Map<String,Object>model = new HashMap<>();
           Squad newSquad= Squad.findById(Integer.parseInt(request.params(":id")));
           List<Hero>Masters = newSquad.getHeroes();
           model.put("newSquad",newSquad);
           model.put("Masters",Masters);
            return modelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/postNewArthur",(request, response)->{
            Map <String,Object>model = new HashMap<>();
            Squad squad=Squad.findById(Integer.parseInt(request.queryParams(":name")));
            List<Hero>heroSquad = squad.getHeroes();
            model.put("squad",squad);
            model.put("heroSquad",heroSquad);
            return new ModelAndView(model,"squad.hbs");
        }, new HandlebarsTemplateEngine());
*/
        post("/hero/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name= request.queryParams(":name");
            int age = Integer.parseInt(request.queryParams(":id"));
            String power = request.queryParams(":specialPower");
            String weakness = request.queryParams((":weakness"));
            Hero hero = new Hero(name,age,power,weakness);
            return new ModelAndView(model, "success.hbs");
         }, new HandlebarsTemplateEngine());

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hero> heroes = Hero.getAll();
            model.put("Heroes", heroes);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        }

    }
