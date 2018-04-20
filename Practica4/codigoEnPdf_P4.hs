-- *****************************
-- Exercises 
-- Practice 4 of LTP
-- *****************************

-------------------------------------------------------------------
-- WARNING:
-- 	ESTE FICHERO SE PROPORCIONA PARA FACILITAR
--	LA COPIA DE LINEAS DE CODIGO DE AQUI AL PROGRAMA DEL ALUMNO
--      ESTE FICHERO NO COMPILA
--	EL INTERPRETE DE HASKELL GENERA UN PARSE ERROR
--	SI SE EJECUTA :load codigoEnPdf_P4
-------------------------------------------------------------------

-- *** Section 3. Reduction Strategy ***

repeat' :: a -> [a]
repeat' x = xs where xs = x:xs

take' :: Int -> [a] -> [a]
take' _ [] = []
take' n (x:t) 
         | n<=0      = []
         | otherwise = x : take' (n - 1) t


-- *** Exercise 1 - Practice 4 *** 

decBin :: Int -> [Int]
decBin x = if x < 2 then [x]
           else (x `mod` 2) : decBin (x `div` 2)

-- example:
-- decBin 4 ==> [0,0,1]


-- *** Exercise 2 - Practice 4 *** 

binDec :: [Int] -> Int
binDec (x:[]) = x
binDec (x:y)  = x + binDec y * 2

-- example:
-- binDec [0,1,1] ==> 6


-- *** Exercise 3 - Practice 4 *** 

divisors :: Int -> [Int]

-- example: 
-- divisors 24 ==> [1,2,3,4,6,8,12,24]


-- *** Exercise 4 - Practice 4 *** 

member :: Int -> [Int] -> Bool

-- examples: 
-- member 1 [1,2,3,4,8,9] ==> True
-- member 0 [1,2,3,4,8,9] ==> False


-- *** Exercise 5 - Practice 4 *** 

isPrime :: Int -> Bool
primes :: Int -> [Int]

-- examples: 
-- isPrime 2 ==> True
-- primes 5  ==> [1,2,3,5,7]


-- *** Exercise 6 - Practice 4 *** 

repeated :: Int -> [Int] -> Int

-- example: 
-- repeated 2 [1,2,3,2,4,2] ==> 3


-- *** Exercise 7 - Practice 4 *** 

concat' :: [[a]] -> [a]

-- example: 
-- concat' [[1,2],[3,4],[8,9]] ==> [1,2,3,4,8,9]


-- *** Exercise 8 - Practice 4 *** 

selectEven :: [Int] -> [Int]

-- example: 
-- selectEven [1,2,4,5,8,9,10] ==> [2,4,8,10]


-- *** Exercise 9 - Practice 4 *** 

selectEvenPos :: [Int] -> [Int]

-- example: 
-- selectEvenPos [1,2,4,5,8,9,10] ==> [1,4,8,10]


-- *** Exercise 10 - Practice 4 *** 

iSort :: [Int] -> [Int]
ins :: Int -> [Int] -> [Int]

-- example: 
-- iSort [4,9,1,3,6,8,7,0] ==> [0,1,3,4,6,7,8,9]
-- ins 5 [0,1,3,4,6,7,8,9] ==> [0,1,3,4,5,6,7,8,9]


-- *** Exercise 11 - Practice 4 *** 

doubleAll :: [Int] -> [Int]

-- example: 
-- doubleAll [1,2,4,5] ==> [2,4,8,10]


-- *** Exercise 12 - Practice 4 *** 

map' :: (a -> b) -> [a] -> [b]

filter' :: (a -> Bool) -> [a] -> [a]


-- *** Exercise 13 - Practice 4 *** 

(sum . map square . filter even) [1..10]


-- *** Section 6.1. Enumerations ***

data Color = Red | Green | Blue


-- *** Section 6.2. Renamed types ***

type Distance = Float
type Angle = Float
type Position = (Distance,Angle)
type Pairs a = (a,a)
type Coordinates = Pairs Distance


-- *** Exercise 14 - Practice 4 *** 

type Person = String
type Book = String
type Database = [(Person, Book)]

exampleBase :: Database
exampleBase = [("Alicia", "El nombre de la rosa"), 
               ("Juan", "La hija del canibal"), 
               ("Pepe", "Odesa"), 
               ("Alicia", "La ciudad de las bestias")]

obtain :: Database -> Person -> [Book]
obtain dBase thisPerson
 = [book | (person,book) <- dBase, person == thisPerson]


borrow :: Database -> Book -> Person -> Database
return' :: Database -> (Person,Book) -> Database


-- *** Section 6.3. Trees ***

--data TreeInt = Leaf Int | Branch TreeInt TreeInt
data TreeInt = Leaf1 Int | Branch1 TreeInt TreeInt

-- examples: 
-- let t1 = Leaf1 4
-- let t2 = Branch1 (Leaf1 5) (Leaf1 7) 


data Tree a = Leaf a | Branch (Tree a) (Tree a) deriving Show

-- examples: 
-- let t3 = Leaf 4
-- let t4 = Branch (Leaf 5) (Leaf 7) 
-- let t5 = Leaf 'q'
-- let t6 = Branch (Leaf "patata") (Leaf "cebolla") 

-- *** Exercise 15 - Practice 4 *** 

numleaves (Leaf x)     = 1
numleaves (Branch a b) = numleaves a + numleaves b

-- examples: 
-- numleaves (Leaf 3) ==> 1
-- numleaves (Branch (Leaf 6) (Leaf 8)) ==> 2


-- *** Exercise 16 - Practice 4 *** 

symmetric :: Tree a -> Tree a

-- example: 
-- symmetric (Branch (Leaf 5) (Leaf 7))


-- *** Exercise 17 - Practice 4 *** 

listToTree :: [a] -> Tree a
treeToList :: Tree a -> [a]


-- *** Section 6.3. Binary trees ***

data BinTreeInt = Void | Node Int BinTreeInt BinTreeInt deriving Show

let treeB1 = Void
let treeB2 = (Node 5) Void Void
let treeB3 = (Node 5) 
             ((Node 3)(Node 1 Void Void)(Node 4 Void Void)) 
             ((Node 6) Void (Node 8 Void Void))


-- *** Exercise 18 - Practice 4 *** 

insTree :: Int -> BinTreeInt -> BinTreeInt

-- example: 
-- insTree 6 (Node 3 (Node 2 Void Void) (Node 7 (Node 4 Void Void) (Node 9 Void Void)))
-- ==> Node 3 (Node 2 Void Void) (Node 7 (Node 4 Void (Node 6 Void Void)) (Node 9 Void Void))


-- *** Exercise 19 - Practice 4 *** 

creaTree :: [Int] -> BinTreeInt

-- example: 
-- creaTree [3,2,4,1]
-- ==> Node 1 Void (Node 4 (Node 2 Void (Node 3 Void Void)) Void)
 

-- *** Exercise 20 - Practice 4 *** 

treeElem :: Int -> BinTreeInt -> Bool

-- examples: 
-- treeElem 9 (Node 3 (Node 2 Void Void) (Node 7 (Node 4 Void Void) (Node 9 Void Void)))
-- ==> True
-- treeElem 6 (Node 3 (Node 2 Void Void) (Node 7 (Node 4 Void Void) (Node 9 Void Void)))
-- ==> False


-- *** Exercise 21 - Practice 4 *** 

dupElem :: BinTreeInt -> BinTreeInt

-- examples: 
-- dupElem treeB1 ==> Void
-- dupElem treeB2 ==> Node 10 Void Void
-- dupElem treeB3 ==> Node 10
--                    (Node 6 (Node 2 Void Void) (Node 8 Void Void))
--                    (Node 12 Void (Node 16 Void Void))


-- *** Exercise 22 - Practice 4 *** 

data Tree' a = Branch' a (Tree' a) (Tree' a) | Void'
	deriving Show

countProperty :: (a -> Bool) -> (Tree' a) -> Int

-- examples: 
-- countProperty (>9) (Branch' 5 (Branch' 12 Void' Void') Void') ==> 1
-- countProperty (>0) (Branch' 5 (Branch' 12 Void' Void') Void') ==> 2

