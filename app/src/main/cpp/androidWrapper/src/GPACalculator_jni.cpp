#include "GPACalculator_jni.h"
#include "GPACalculator.h"

#include <jni.h>
#include <iostream>

JNIEXPORT jlong JNICALL Java_com_ekutt_example_gpacalculator_GPACalculator_nativeCreateObject
  (JNIEnv *, jobject) {
    return (jlong) new GPACalculator();
}

JNIEXPORT jobject JNICALL Java_com_ekutt_example_gpacalculator_GPACalculator_calculateGPAs
  (JNIEnv* env, jobject, jlong nativeObjectHandle) {
    jclass resultClass = env->FindClass("com/ekutt/example/gpacalculator/Result");

    std::vector<GPACalculator::NameGpaCreditTuple> gparesults =
            ((GPACalculator*)nativeObjectHandle)->calculateGPAs();

    //jobjectArray objarray = env->NewObjectArray(gparesults.size() ,resultClass ,0);
    jclass java_util_ArrayList      = static_cast<jclass>(env->NewGlobalRef(env->FindClass("java/util/ArrayList")));
    jmethodID java_util_ArrayList_     = env->GetMethodID(java_util_ArrayList, "<init>", "(I)V");
    jmethodID java_util_ArrayList_add  = env->GetMethodID(java_util_ArrayList, "add", "(Ljava/lang/Object;)Z");

    jobject objarray = env->NewObject(java_util_ArrayList, java_util_ArrayList_, (jint)gparesults.size());
    jmethodID resultConstructor = env->GetMethodID(resultClass, "<init>", "(Ljava/lang/String;IF)V");

    int index = 0;
    for(auto& tuple : gparesults) {
        auto& name = std::get<0>(tuple);
        jfloat gpa = std::get<1>(tuple);
        jint credits = std::get<2>(tuple);
        jstring nameStr = env->NewStringUTF(name.c_str());

        jobject resultObject = env->NewObject(resultClass, resultConstructor, nameStr, credits, gpa);
        //env->SetObjectArrayElement(objarray, index, resultObject);
        env->CallBooleanMethod(objarray, java_util_ArrayList_add, resultObject);
        ++index;
    }

    return objarray;
}

JNIEXPORT void JNICALL Java_com_ekutt_example_gpacalculator_GPACalculator_addGrade
  (JNIEnv* env, jobject, jlong nativeObjectHandle, jstring nameStr, jfloat grade, jint credit) {
    jboolean isCopy;
    const char *convertedStr = (env)->GetStringUTFChars(nameStr, &isCopy);
    env->ReleaseStringUTFChars(nameStr, convertedStr);
    const jsize length = (*env).GetStringLength(nameStr);

    std::string name = std::string(convertedStr, length);

    GPACalculator* nativeGpaCalcInstance = (GPACalculator*)nativeObjectHandle;
    nativeGpaCalcInstance->addGrade(name, grade, credit);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_ekutt_example_gpacalculator_GPACalculator_clearData(JNIEnv *env, jobject thiz,
                                                         jlong nativeObjectHandle) {
    ((GPACalculator*)nativeObjectHandle)->clearData();
}