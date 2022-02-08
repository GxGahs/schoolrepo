quicksort :: Ord a => [a] -> [a]
quicksort [] = []
quicksort [x] = [x]
quicksort (x:xs) = sortedLessEq ++ [x] ++ sortedGreater
                   where sortedLessEq = quicksort [y | y <- xs, y <= x]
                         sortedGreater = quicksort [y | y <- xs, y > x]
