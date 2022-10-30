package org.example.utils.features;

import org.example.models.dto.ParsedText;

public interface Calculable {

  double calculateFeature(ParsedText text);
}
