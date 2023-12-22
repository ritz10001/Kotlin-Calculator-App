package com.example.calculator


import android.util.Log
import net.objecthunter.exp4j.ExpressionBuilder

class Operations {

    private var evaluationString = ""
    private var finalString = ""
    var finalResult = ""
    private var resultArray = mutableListOf<String>()
    private var operationsLimit = 0
    private var periodLimit = 0


    fun addValue(param: Int){
        this.evaluationString += "$param"
        this.operationsLimit = 0
    }

    fun addPeriod(){
        if(this.periodLimit==0){
            this.evaluationString += "."
            this.periodLimit += 1
        }
    }

    fun addition(){
        if(operationsLimit<2){
            this.evaluationString += "+"
            this.operationsLimit += 1
            this.periodLimit = 0
        }
    }

    fun subtraction(){
        if(operationsLimit<2){
            this.evaluationString += "-"
            this.operationsLimit += 1
            this.periodLimit = 0
        }
    }

    fun multiplication(){
        if(operationsLimit<2){
            this.evaluationString += "*"
            this.operationsLimit += 1
            this.periodLimit = 0
        }
    }

    fun division(){
        if(operationsLimit<2){
            this.evaluationString += "/"
            this.operationsLimit += 1
            this.periodLimit = 0
        }
    }

    fun equals(): String{
        var counter = 0
        var operationSymbol = "+-*/"
        var numSymbol = "0123456789."
        var prevType = ""

        var splitArray = mutableListOf<String>()

        for(i in this.evaluationString){
            splitArray.add(i.toString())
        }

        var c = 0

        for(i in splitArray){
            if(c==0){
                if(operationSymbol.contains(splitArray[0])){
                    prevType="operatorType"
                }
                else{
                    prevType="intType"
                }
                c += 1
                resultArray.add(counter,splitArray[0])
            }
            else{
                if(operationSymbol.contains(i) && prevType=="operatorType"){
                    resultArray[counter] += i
                    prevType="operatorType"
                }
                else if(numSymbol.contains(i) && prevType=="intType"){
                    resultArray[counter] += i
                    prevType="intType"
                }
                else if(operationSymbol.contains(i) && prevType=="intType"){
                    counter += 1
                    resultArray.add(counter,i)
                    prevType="operatorType"

                }
                else if(numSymbol.contains(i) && prevType=="operatorType"){
                    counter += 1
                    resultArray.add(counter,i)
                    prevType="intType"

                }
            }

        }

        for(i in this.resultArray){
            Log.d("nothing", i)
        }
        var answer = parseEquation(this.resultArray)
        return answer
    }

    fun parseEquation(arr: List<String>): String{
        for(i in arr){
            if(i=="++" || i=="--" || i=="+"){
                finalString+="+"
            }
            else if(i=="+-" || i=="-+" || i=="-"){
                finalString+="-"
            }
            else if(i=="*" || i=="/*" || i=="**"){
                finalString+="*"
            }
            else if(i=="/" || i=="*/" || i=="//"){
                finalString+="/"
            }
            else{
                finalString+=i
            }
        }
        Log.d("nothing", finalString)

        var finalResult = ExpressionBuilder(finalString).build().evaluate().toString()

        Log.d("nothing", finalResult)


        clearAll()

        return finalResult



    }

    fun clearAll(){
        evaluationString = finalResult
        finalString = ""
        resultArray = emptyArray<String>().toMutableList()
    }

}