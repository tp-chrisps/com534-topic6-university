// TuiApplication
// An application class, to handle console input/output.
// A TuiApplication object is created in main(), and its run() method called to enter the main loop of the application.
class TuiApplication {
    val university = University()

    fun addStudent() {
        println("Enter name:")
        val name = readln()
        println("Enter course:")
        val course = readln()
        println("Enter id:")
        val id = readln()
        university.addStudent(Student(id, name, course))
    }

    fun searchForStudentById() {
        println("Enter ID:")
        val id = readln()
        val student = university.findStudentById(id)
        if (student == null) {
            println("No student found")
        } else {
            println(student)
        }
    }

    fun searchForStudentsByCourse() {
        println("Enter course:")
        val course = readln()
        val students = university.findStudentsByCourse(course)
        if (students.isEmpty()) {
            println("No matching students")
        } else {
            for (s in students) {
                println(s)
            }
        }
    }

//    override fun onMenuItemSelected(choice: Int) {
//        when (choice) {
//            0-> addStudent()
//            1-> searchForStudentById()
//            2-> searchForStudentsByCourse()
//        }
//    }



    fun run() {



        // Array of handlers for each menu item.

//        val menuHandlers = arrayOf<MenuItemHandler> (object : MenuItemHandler {
//            override fun onMenuItemSelected(choice: Int) {
//                addStudent()
//            }
//        },
//            object : MenuItemHandler {
//                override fun onMenuItemSelected(choice: Int) {
//                    searchForStudentById()
//                }
//            },
//            object : MenuItemHandler {
//                override fun onMenuItemSelected(choice: Int) {
//                    searchForStudentsByCourse()
//                }
//            })
        val menuHandlers = arrayOf<MenuItemHandler> (
            MenuItemHandler { addStudent() },
            MenuItemHandler { searchForStudentById() },
            MenuItemHandler { searchForStudentsByCourse() })

        var running = true
        while (running) {
            // Display the menu items. forEachIndexed() is similar to forEach but provides an index as the first
            // parameter of the lambda.
            println("0: Add Student")
            println("1: Search for Student By ID")
            println("2: Search for Students By course")
            println("3: Quit")

            // Read the user input
            val input = readln().toInt()

            // If the input is 0-2, call the onMenuItemSelected() of the appropriate handler.
            when (input) {
                in 0..2 -> menuHandlers[input].onMenuItemSelected(input)
                3 -> running = false
                else -> println("Error: invalid option")
            }
        }
    }
}
