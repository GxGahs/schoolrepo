myNull :: [a] -> Bool
myNull [] = True
myNull (x:xs) = False

(+++) :: [a] -> [a] -> [a]
(+++) [] []         =        []
(+++) [] (y:ys)     =        (y:ys)
(+++) (x:xs) []     =        (x:xs)
(+++) (x:xs) (y:ys) =        x:(xs +++ (y:ys))

myHead :: [a] -> a
myHead [] = error "empty list."
myHead (x:xs) = x

myTail :: [a] -> [a]
myTail [] = error "empty list."
myTail [_] = []
myTail (x:xs) = xs

myReverse :: [a] -> [a]
myReverse [] = []
myReverse [x] = [x]
myReverse (x:xs) = (myReverse xs) +++ [x]

myLast :: [a] -> a
myLast [] = error "empty list."
myLast [x] = x
myLast (x:xs) = myLast xs

--cases implementation of myLast done for practice
myLastCases :: [a] -> a
myLastCases lst = case lst of
            [] -> error "empty list."
            [x] -> x
            (x:xs) -> myLast xs

myInit :: [a] -> [a]
myInit [] = error "empty list."
myInit [_] = []
myInit (x:xs) = x:(myInit xs)

myLength :: [a] -> Int
myLength [] = 0
myLength (x:xs) = 1 + myLength xs

myTake :: Int -> [a] -> [a]
myTake n [] = []
myTake n [x] = if (n > 0) then [x] else []
myTake n (x:xs) = if (n > 0)
                  then x:(myTake (n-1) xs)
                  else []

--implementation of myDrop from the textbook
myDropTextbook :: Int -> [a] -> [a]
myDropTextbook n xs = if (n <= 0 || myNull xs)
                      then xs
                      else myDropTextbook (n - 1) (myTail xs)

myDrop :: Int -> [a] -> [a]
myDrop n [] = []
myDrop n (xs)   | n <= 0 = xs
                | n >  0 = myDrop (n-1) (myTail xs)

myMaximum :: Ord a => [a] -> a
myMaximum [] = error "empty list."
myMaximum [x] = x
myMaximum (x:xs)  | x > pMax = x
                  | otherwise = pMax
                  where pMax = myMaximum xs

myMinimum :: Ord a => [a] -> a
myMinimum [] = error "empty list."
myMinimum [x] = x
myMinimum (x:xs)   | x < pMin = x
                   | otherwise = pMin
                   where pMin = myMinimum xs

mySum :: Num a => [a] -> a
mySum [] = 0
mySum (x:xs) = x + mySum xs

myProduct :: Num a => [a] -> a
myProduct [] = 1
myProduct (x:xs) = x * myProduct xs

myElem ::Eq a => a -> [a] -> Bool
myElem _ [] = False
myElem q (x:xs) | q == x = True
                | otherwise = myElem q xs


--comment
