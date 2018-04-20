module Practica4 where

decBin :: Int -> [Int]
decBin x 
	| x< 2 = [x]
	| otherwise x = (mod x 2):decBin(div x 2)
