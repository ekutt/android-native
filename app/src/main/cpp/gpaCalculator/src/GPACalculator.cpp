#include "GPACalculator.h"

std::vector<GPACalculator::NameGpaCreditTuple> GPACalculator::calculateGPAs()
{
  std::vector<GPACalculator::NameGpaCreditTuple> resultVec;
  for(auto& nameGradesPair : studentData)
  {
    float total_credits = 0.0f;
    float total_points = 0.0f;
    for_each(nameGradesPair.second.begin(), nameGradesPair.second.end(),
        [&total_credits, &total_points](const GradeCreditPair& pair)
        {
            total_points += pair.first * pair.second;
            total_credits += pair.second;
        });
    resultVec.push_back(std::make_tuple(nameGradesPair.first, total_points/total_credits, total_credits));
  }
  return resultVec;
}

void GPACalculator::addGrade(const std::string& name, float grade, int credits)
{
  auto& gradesVec = studentData[name];
  gradesVec.push_back(std::make_pair(grade, credits));
}

void GPACalculator::clearData()
{
  studentData.clear();
}