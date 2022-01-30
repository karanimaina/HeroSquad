import Models.Hero;
import Models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
//houte for displaying the home page
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "Welcome.hbs");
        }, new HandlebarsTemplateEngine());
//route for accessing the hero-form
        get("/heroes/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("squads",Squad.getAll());
            return new ModelAndView(model, "Hero-form.hbs");
        }, new HandlebarsTemplateEngine());
//creates a new hero object
        post("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hero> heroes = request.session().attribute("heroes");
            if (heroes == null) {//if exists
                heroes = new ArrayList<>();
                request.session().attribute("heroes", heroes);
            }
            Squad squad = Squad.findById(Integer.parseInt(request.queryParams("squadId")));
            //access the id of the squad object created
            String name = request.queryParams("name");
            int age  = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name,age,power,weakness,squad.getId());//creates hero object from  the passed parameters
            heroes.add(newHero);
            return new ModelAndView(model, "success-h.hbs");
        }, new HandlebarsTemplateEngine());
//route for checking the hero details
        get("/heroes",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hero> heroes = Hero.getAll();
            model.put("heroes", heroes);
            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());
//route for accessing an individual hero from the arraylist
        get("/heroes/:Id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Hero hero= Hero.findById(Integer.parseInt(req.params(":Id")));
            Squad squad = Squad.findById(hero.getSquadId());
            model.put("hero", hero);
            model.put("squad",squad);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());
//gets the squad objects into the hero-form  for assigning new hero objects created into a squad
        get("/heroes/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("squads",Squad.getAll());
            return new ModelAndView(model, "Hero-form.hbs");
        }, new HandlebarsTemplateEngine());

//gets the hero squad form
        get("/squads/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squadForm.hbs");
        }, new HandlebarsTemplateEngine());
//creates a hero form object
        post("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Squad> squads = request.session().attribute("squads");
            if(squads == null) {//if exists
                squads = new ArrayList<>();
                request.session().attribute("squads", squads);
            }

            String name = request.queryParams("name");//fetching the value from the user generated data
            int size = Integer.parseInt(request.queryParams("size"));
            String cause = request.queryParams("cause");

            Squad newSquad = new Squad(name, size, cause);
            squads.add(newSquad);
            return new ModelAndView(model, "success-s.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Squad> squads = Squad.getAll();
            model.put("squads", squads);
            return new ModelAndView(model, "squads.hbs");
        }, new HandlebarsTemplateEngine());
//gets a specific squad from the list generated  and  displays it in the squad.hbs
        get("squads/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Squad squad = Squad.findById(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("heroes-in-squad",squad.getHeroes());
            return new ModelAndView(model,"squad.hbs");
        }, new HandlebarsTemplateEngine());

    }
    }
