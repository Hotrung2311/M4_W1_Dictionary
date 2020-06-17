package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class Dictionary {

    public HashMap<String, String> myDictionary = new HashMap<>();

    public String search(String word){
        String result;
        result = myDictionary.get(word);
        if (result == null){
            result = "not found";
        }
        return result;
    }

    @PostMapping("/dictionary")
    public String searchWord(@RequestParam String word, Model model){
        myDictionary.put("Hello", "Xin chào");
        myDictionary.put("Fuck", "Đụ");
        model.addAttribute("word", search(word));
        return "result";
    }

    @GetMapping("/dictionary")
    public String showMeaning(@RequestParam String word,Model model){
        return "result";
    }
}
