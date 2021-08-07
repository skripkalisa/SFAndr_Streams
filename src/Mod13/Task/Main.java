package Mod13.Task;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> forms = new ArrayList<>();
    forms.add("bare infinitive");
    forms.add("past");
    forms.add("present participle");
    forms.add("past participle");
    List<String> endings = new ArrayList<>();
    endings.add("");
    endings.add("ed");
    endings.add("ing");
    endings.add("ed");

    VerbForm verb = new VerbForm("finish", forms, endings);
    // VerbForm verb = new VerbForm("finish");
    verb.getVerb();
    verb.getForm();
    verb.getEnding();

  }
}
