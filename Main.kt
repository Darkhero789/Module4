class Grocery(var items: MutableList<String>, var prices: MutableList<Float>, var quantities: MutableList<Int>) {
    fun one() {
        println("What is the name of the item? ")
        val item = readLine()!!
        println("What is the price of the item? ")
        val price = readLine()!!.toFloat()
        println("What is the quantity of the item? ")
        val quantity = readLine()!!.toInt()
        items.add(item)
        prices.add(price)
        quantities.add(quantity)
        val length = items.size - 1
        println("Grocery list: ")
        for (l in 0..length) {
            println("${items[l]} $${prices[l]} ${quantities[l]}")
        }
    }
    fun two() {
        var index = 0
        var found = false
        println("What item are you changing the price of? ")
        val item = readLine()
        println("What is the items new price? ")
        val price = readLine()!!.toFloat()
        for (x in items) {
            if (x == item) {
                index = items.indexOf(x)
                found = true
            }
        }
        if (found == true) {
            prices[index] = price
            var length = items.size - 1
            println("Updated grocery list")
            for (l in 0..length) {
                println("${items[l]} $${prices[l]} ${quantities[l]}")
            }
        }
        else {
            println("item not found")
        }
    }
    fun three() {
        var index = 0
        var found = false
        println("What item are you changing the quantity of? ")
        val item = readLine()!!
        println("What is the new quantity of the item? ")
        val quantity = readLine()!!.toInt()
        for (x in items) {
            if (x == item) {
                index = items.indexOf(x)
                found = true
            }
        }
        if (found == true) {
            quantities[index] = quantity
            var length = items.size - 1
            for (l in 0..length) {
                println("${items[l]} $${prices[l]} ${quantities[l]}")
            }
        }
        else {
            println("Item not found")
        }
    }
    fun four() {
        var index = 0
        var found = false
        println("What item are you wanting to delete? ")
        var item = readLine()!!
        for (x in items) {
            if (x == item){
                index = items.indexOf(x)
                found = true
            }
        }
        if (found == true) {
            items.removeAt(index)
            prices.removeAt(index)
            quantities.removeAt(index)
            var length = items.size - 1
            for (l in 0..length) {
                println("${items[l]} $${prices[l]} ${quantities[l]}")
            }
        }
        else {
            println("Item not found")
        }
    }
    fun five() {
        var total = 0.00
        var length = items.size - 1
        for (l in 0..length) {
            total += prices[l] * quantities[l].toFloat()
            total = total * 1.06
        }
        println("Total price: $${"%.2f".format(total)}")
    }
}

fun main(args: Array<String>) {
    var items = mutableListOf<String>()
    var prices = mutableListOf<Float>()
    var quantities = mutableListOf<Int>()
    var grocery = Grocery(items, prices, quantities)
    println("Hello and welcome to the grocery list program!")
    var loop = true
    while (loop == true) {
        println("Please choose one of the following options by inputting their number.")
        println("1. add item")
        println("2. change price of item")
        println("3. change quantity of the item")
        println("4. Delete an item")
        println("5. Finish program and give the total price")
        val number = Integer.valueOf(readLine())
        if (number == 1) {
            grocery.one()
        }
        else if (number == 2) {
            grocery.two()
        }
        else if (number == 3) {
            grocery.three()
        }
        else if (number == 4) {
            grocery.four()
        }
        else if (number == 5) {
            loop = false
            grocery.five()
        }
        else {
            println("Sorry that is an invalid option")
        }
    }
}
