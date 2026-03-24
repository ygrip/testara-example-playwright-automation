package io.github.ygrip.automation.model;

import java.util.List;

import lombok.Data;

@Data
public class Pokemon {
  private Integer number;
  private String name;
  private String image;
  private String link;
  private List<String> types;
}
