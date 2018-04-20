module Exercises where
import Data.Char

numCbetw2 :: Char -> Char -> Int
numCbetw2 x y
	| x == y = 0
	| otherwise = abs ((ord y) -(ord x)-1) 

maximo :: (Int,Int) -> Int
maximo (x,y)
	| x==y = x
	| x>y = x
	| otherwise = y
otherSum :: Int -> Int -> Int
otherSum a b
	| a == b = b
	| a + 1 == b = a + b
	| a + 1 == b - 1 = a + a + 1 + b
	| otherwise = a + b + otherSum (a + 1) (b - 1)
leapyear :: Int -> Bool
leapyear y = ((mod y 4) == 0 && (mod y 100) /= 0) || (mod y 400) == 0
daysAMonth :: Int -> Int -> Int
daysAMonth m y
	| m == 2 && leapyear y = 29
	| m == 2 = 28
	| m == 4 || m == 6 || m == 9 || m == 11 = 30
	| otherwise = 31
