#ifndef ARITHMETIC_OPERATIONS_H
#define ARITHMETIC_OPERATIONS_H

#include <map>
#include <set>
#include <string>
#include <tuple>
#include <vector>

class GPACalculator{
public:
  using NameGpaCreditTuple = std::tuple<std::string, float, int>;
  __attribute__((visibility("default"))) std::vector<NameGpaCreditTuple> calculateGPAs();
  __attribute__((visibility("default"))) void addGrade(const std::string& name, float grade, int credits);
  __attribute__((visibility("default"))) void clearData();

private:
  using GradeCreditPair = std::pair<float, int>;
  std::map<std::string, std::vector<GradeCreditPair>> studentData;
};

#endif
