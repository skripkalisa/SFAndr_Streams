package Mod13.Task;

import java.util.ArrayList;
import java.util.List;

public final class VerbForm {
  private final String verb;
  private final List<String> form;
  private final List<String> ending;

  public VerbForm(String verb) {
    this.verb = verb;
  }

  public VerbForm(String verb, List<String> form, List<String> ending) {
    this.verb = verb;
    this.form = new ArrayList<>(form);
    this.ending = new ArrayList<>(ending);
  }

  public String getVerb() {
    System.out.println(verb);
    return verb;
  }

  public List<String> getForm() {
    for (String verbForm : this.form) {
      System.out.print(verbForm + "\t | ");
    }
    System.out.println("");
    return new ArrayList<>(form);
  }

  public List<String> getEnding() {
    for (String verbEnding : this.ending) {
      System.out.print(verb + verbEnding + "\t | ");
    }
    System.out.println("");
    return new ArrayList<>(ending);
  }
}
