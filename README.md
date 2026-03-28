# 🚀 Broken Cargo Bot - Manifest Processor

## 📌 Overview

This project processes a cargo manifest using custom logic without relying on standard length functions. It filters items, calculates priority, and sorts them.

---

## ⚙️ Features

* Manual counting using iteration
* Filters items with same first and last letters
* Calculates priority using ASCII values
* Uses Bubble Sort (stable sorting)

---

## 🧠 Design Decisions

### Iteration vs Recursion

Iteration is used because it avoids stack overflow and is easier to control.

### Manual Counting

Instead of using `.length`, a loop with try-catch is used.

### Sorting

Bubble Sort ensures stable ordering.

---

## 🛠️ How to Run

```bash
javac CargoBot.java
java CargoBot
```

---

## 📌 Example

Input:
["Apple", "Banana", "Cat", "Level"]

Output:
{total_items_processed=4, discarded_count=1, final_order=[Cat, Apple, Banana]}

---

## 📂 Files

* CargoBot.java → main code
* README.md → documentation
